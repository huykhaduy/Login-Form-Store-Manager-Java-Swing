package com.group.dragndropdesign;

import com.formdev.flatlaf.FlatLightLaf;

public class FormTheme
	extends FlatLightLaf
{
	public static final String NAME = "FormTheme";

	public static boolean setup() {
		return setup( new FormTheme() );
	}

	public static void installLafInfo() {
		installLafInfo( NAME, FormTheme.class );
	}

	@Override
	public String getName() {
		return NAME;
	}
}
