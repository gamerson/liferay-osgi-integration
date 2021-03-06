/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.osgi.integration.tests.strutsactions;

import com.liferay.portal.kernel.struts.BaseStrutsAction;
import com.liferay.portal.kernel.struts.StrutsAction;

import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

/**
 * @author Raymond Augé
 */
@Component(
	immediate = true,
	property = {
		"path=/portal/action_one"
	},
	service = StrutsAction.class
)
public class StrutsAction_One extends BaseStrutsAction {

	@Override
	public String execute(
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		System.out.println(this + " says: Hello World!");

		ServletOutputStream outputStream = response.getOutputStream();

		PrintWriter printWriter = new PrintWriter(outputStream);

		printWriter.println("Hello World!");

		printWriter.close();

		return null;
	}

	/**
	 * This is just part of the OSGi DS lifecycle. It's not part of the struts
	 * action feature.
	 */
	@Activate
	private void activate() {
		System.out.println(this + " activated!");
	}

	/**
	 * This is just part of the OSGi DS lifecycle. It's not part of the struts
	 * action feature.
	 */
	@Deactivate
	private void deactivate() {
		System.out.println(this + " deactivated!");
	}

}