/**
 * 
 */
package de.hybris.platform.cuppytrail.facades;

import de.hybris.platform.cuppytrail.data.StadiumData;

import java.util.List;


/**
 * @author radmike
 * 
 */
public interface StadiumFacade
{

	StadiumData getStadium(String name);

	List<StadiumData> getStadiums();

}
