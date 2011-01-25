/*
 * This file is part of the DITA Open Toolkit project hosted on
 * Sourceforge.net. See the accompanying license.txt file for 
 * applicable licenses.
 */

/*
 * (c) Copyright IBM Corp. 2011 All Rights Reserved.
 */
package org.dita.dost.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.xml.sax.Locator;
import org.xml.sax.SAXParseException;

public class SAXExceptionWrapperTest {

	private final Locator l = new Locator() {
		public int getColumnNumber() {
			return 1;
		}
		public int getLineNumber() {
			return 3;
		}
		public String getPublicId() {
			return "publicId";
		}
		public String getSystemId() {
			return "systemId";
		}
	};

	@Test
	public void testSAXExceptionWrapperStringLocator() {
		new SAXExceptionWrapper("message", l);
	}

	@Test
	public void testSAXExceptionWrapperStringLocatorException() {
		new SAXExceptionWrapper("message", l, new RuntimeException("msg"));
	}

	@Test
	public void testSAXExceptionWrapperStringStringStringIntInt() {
		new SAXExceptionWrapper("message", "publicId", "systemId", 3, 1);
	}

	@Test
	public void testSAXExceptionWrapperStringStringStringIntIntException() {
		new SAXExceptionWrapper("message", "publicId", "systemId", 3, 1, new RuntimeException("msg"));
	}

	@Test
	public void testSAXExceptionWrapperStringSAXParseException() {
		new SAXExceptionWrapper("message", new SAXParseException("msg", l));
	}

	@Test
	public void testGetMessage() {
		final SAXExceptionWrapper e = new SAXExceptionWrapper("message", new SAXParseException("msg", l));
		final String act = e.getMessage();
		final String exp = new StringBuilder()
			.append("message")
			.append(" Line ")
			.append(l.getLineNumber())
			.append(":")
			.append("msg")
			.append(System.getProperty("line.separator")).toString();
		assertEquals(exp, act);
	}

}
