/* LanguageTool, a natural language style checker 
 * Copyright (C) 2020 Jaume Ortolà
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301
 * USA
 */
package org.languagetool.rules.ca;

import java.io.IOException;
import java.util.Collections;
import java.util.Locale;
import java.util.ResourceBundle;

import org.languagetool.JLanguageTool;
import org.languagetool.language.Catalan;
import org.languagetool.rules.AbstractFindSuggestionsFilter;
import org.languagetool.rules.Rule;
import org.languagetool.tagging.Tagger;
import org.languagetool.tagging.ca.CatalanTagger;

public class FindSuggestionsFilter extends AbstractFindSuggestionsFilter {

  private static final CatalanTagger tagger = new CatalanTagger(new Catalan());
  private MorfologikCatalanSpellerRule morfologikRule;
  
  public FindSuggestionsFilter() throws IOException {
    ResourceBundle messages = JLanguageTool.getDataBroker().getResourceBundle(JLanguageTool.MESSAGE_BUNDLE,
        new Locale("ca"));
    morfologikRule = new MorfologikCatalanSpellerRule(messages, new Catalan(), null, Collections.emptyList());
  }

  @Override
  protected Tagger getTagger() {
    return tagger;
  }

  @Override
  protected Rule getSpellerRule() {
    return morfologikRule;
  }

  

  
}
