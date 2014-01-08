package com.hybris.cuppytrailbackoffice.widgets;

import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ModelService;

import org.zkoss.zk.ui.event.Events;

import com.hybris.cockpitng.annotations.SocketEvent;
import com.hybris.cockpitng.annotations.ViewEvent;
import com.hybris.cockpitng.components.Editors;
import com.hybris.cockpitng.core.config.CockpitConfigurationException;
import com.hybris.cockpitng.core.config.CockpitConfigurationService;
import com.hybris.cockpitng.core.config.impl.DefaultConfigContext;
import com.hybris.cockpitng.core.config.impl.jaxb.hybris.EditorGroup;
import com.hybris.cockpitng.core.config.impl.jaxb.hybris.EditorProperty;
import com.hybris.cockpitng.util.DefaultWidgetController;


public class CuppyNewItemWizardController extends DefaultWidgetController
{
	private static final String SOCKET_IN_TYPECODE = "type";
	private static final String SOCKET_OUT_NEWITEM = "newItem";

	private Editors wizardEditors;

	private ModelService modelService;
	private CockpitConfigurationService cockpitConfigurationService;

	@SocketEvent(socketId = SOCKET_IN_TYPECODE)
	public void setTypeCode(final String typeCode)
	{
		setValue("typeCode", typeCode);
		getWidgetInstanceManager().setTitle(getLabel("add.new", new Object[]
		{ typeCode }));
		wizardEditors.setConfig("component=cuppywizard,type=" + typeCode);
	}

	@ViewEvent(componentID = "create", eventName = Events.ON_CLICK)
	public void createNew() throws ClassNotFoundException, CockpitConfigurationException
	{
		sendOutput(SOCKET_OUT_NEWITEM, createModel(getValue("typeCode", String.class)));
	}


	private ItemModel createModel(final String typeCode) throws CockpitConfigurationException, ClassNotFoundException
	{
		ItemModel newItem = null;
		final DefaultConfigContext context = new DefaultConfigContext();
		context.addAttribute("component", "cuppywizard");
		context.addAttribute("type", typeCode);

		final com.hybris.cockpitng.core.config.impl.jaxb.hybris.Editors editorsConfig = cockpitConfigurationService
				.loadConfiguration(context, com.hybris.cockpitng.core.config.impl.jaxb.hybris.Editors.class);
		newItem = modelService.create(typeCode);

		for (final EditorGroup group : editorsConfig.getGroup())
		{
			for (final EditorProperty property : group.getProperty())
			{
				modelService.setAttributeValue(newItem, property.getQualifier(),
						getValue(property.getQualifier(), Class.forName(property.getType())));
			}
		}
		modelService.save(newItem);
		return newItem;
	}
}