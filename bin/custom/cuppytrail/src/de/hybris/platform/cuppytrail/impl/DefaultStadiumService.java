/**
 * 
 */
package de.hybris.platform.cuppytrail.impl;

import de.hybris.platform.cuppytrail.StadiumService;
import de.hybris.platform.cuppytrail.daos.StadiumDAO;
import de.hybris.platform.cuppytrail.model.StadiumModel;
import de.hybris.platform.servicelayer.exceptions.AmbiguousIdentifierException;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;


/**
 * @author radmike
 * 
 */
public class DefaultStadiumService implements StadiumService
{
	private StadiumDAO stadiumDAO;


	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hybris.platform.cuppytrail.StadiumService#getStadiums()
	 */
	@Override
	public List<StadiumModel> getStadiums()
	{
		return stadiumDAO.findStadiums();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hybris.platform.cuppytrail.StadiumService#getStadiumForCode(java.lang.String)
	 */
	@Override
	public StadiumModel getStadiumForCode(final String code) throws AmbiguousIdentifierException, UnknownIdentifierException
	{
		final List<StadiumModel> stadiums = stadiumDAO.findStadiumsByCode(code);

		if (stadiums.isEmpty())
		{
			throw new UnknownIdentifierException("Stadium with code '" + code + "' not found!");
		}
		else if (stadiums.size() > 1)
		{
			throw new AmbiguousIdentifierException("Stadium code '" + code + "' is not unique, " + stadiums.size()
					+ " stadiums found!");
		}

		return stadiums.get(0);
	}

	@Required
	public void setStadiumDAO(final StadiumDAO stadiumDAO)
	{
		this.stadiumDAO = stadiumDAO;
	}

}
