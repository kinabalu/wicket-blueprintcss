/*
 * Created by IntelliJ IDEA.
 * User: kinabalu
 * Date: Feb 16, 2010
 * Time: 8:36:24 PM
 */
package com.mysticcoders.common.wicket.blueprint;

import org.apache.wicket.behavior.AbstractBehavior;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.resources.CompressedResourceReference;

public class BlueprintCSS extends AbstractBehavior {

    private final CompressedResourceReference IE_CSS = new CompressedResourceReference(BlueprintCSS.class, "ie.css");
    private final CompressedResourceReference PRINT_CSS = new CompressedResourceReference(BlueprintCSS.class, "print.css");
    private final CompressedResourceReference SCREEN_CSS = new CompressedResourceReference(BlueprintCSS.class, "screen.css");
    private final CompressedResourceReference TABS_CSS = new CompressedResourceReference(BlueprintCSS.class, "tabs.css");
    private final CompressedResourceReference BUTTONS_CSS = new CompressedResourceReference(BlueprintCSS.class, "buttons.css");


	/**
	 * @see org.apache.wicket.markup.html.IHeaderContributor#renderHead(org.apache.wicket.markup.html.IHeaderResponse)
	 */
    @Override
	public void renderHead(IHeaderResponse response) {
//        response.renderJavascriptReference();

        response.renderCSSReference(PRINT_CSS, "print");
        response.renderCSSReference(SCREEN_CSS, "screen, projection");

        response.renderString("<!--[if lt IE 8]>");
        response.renderCSSReference(IE_CSS, "screen, projection");
        response.renderString("<![endif]-->\n");

        response.renderCSSReference(TABS_CSS, "screen, projection");

        response.renderCSSReference(BUTTONS_CSS, "screen, projection");        
	}
}