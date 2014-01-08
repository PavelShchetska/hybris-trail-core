/**
 * 
 */
package de.hybris.platform.cuppytrailfrontend;

import de.hybris.platform.cuppytrail.data.StadiumData;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.log4j.Logger;


/**
 * @author radmike
 * 
 */
public class StadiumsNameEncoded
{
	private final static Logger LOG = Logger.getLogger(StadiumData.class);

	public static String getNameEncoded(final String name)
	{
		try
		{
			return URLEncoder.encode(name, "UTF-8");
		}
		catch (final UnsupportedEncodingException e)
		{
			LOG.error("Problems while encoding", e);
			return "";
		}
	}
}
