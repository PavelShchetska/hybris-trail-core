/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2013 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 * 
 *  
 */
package de.hybris.platform.cuppytrail.enums;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import de.hybris.bootstrap.annotations.UnitTest;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


@UnitTest
public class CuppytrailEnumsTest
{
	/** Edit the local|project.properties to change logging behaviour (properties log4j.*). */
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(CuppytrailEnumsTest.class.getName());

	@Before
	public void setUp()
	{
		// implement here code executed before each test
	}

	@After
	public void tearDown()
	{
		// implement here code executed after each test
	}

	@Test
	public void testStaticEnums()
	{
		final StadiumType st1 = StadiumType.ENCLOSED;
		final StadiumType st2 = StadiumType.ENCLOSED;
		final StadiumType st3 = StadiumType.OPENAIR;
		final StadiumType st4 = StadiumType.OPENAIR;

		assertEquals(st1, st2);
		assertEquals(st3, st4);
		assertNotSame(st1, st4);

		final StadiumType enclosed = Enum.valueOf(StadiumType.class, "ENCLOSED");
		assertNotNull(enclosed);

	}

	@Test
	public void testDynamicEnums()
	{
		final StadiumAccess st1 = StadiumAccess.RAIL;
		final StadiumAccess st2 = StadiumAccess.RAIL;

		assertEquals(st1, st2);

		assertEquals(StadiumAccess.valueOf("RAIL"), st2);
		assertEquals(StadiumAccess.valueOf("NEW_TYPE"), StadiumAccess.valueOf("NEW_TYPE"));
		assertNotSame(StadiumAccess.valueOf("NEW_TYPE"), StadiumAccess.valueOf("OTHER_NEW_TYPE"));

	}
}
