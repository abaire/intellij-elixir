package org.elixir_lang;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.elixir_lang.parser_definition.CharListHeredocParsingTestCase;
import org.elixir_lang.parser_definition.CharListParsingTestCase;

/**
 * Created by luke.imhoff on 8/3/14.
 */
public class ElixirTestCase extends TestCase {
    public static TestSuite suite() {
        TestSuite suite = new TestSuite();

        suite.addTestSuite(org.elixir_lang.parser_definition.AtomParsingTestCase.class);
        suite.addTestSuite(org.elixir_lang.parser_definition.GeneralParsingTestCase.class);
        suite.addTestSuite(org.elixir_lang.parser_definition.SigilParsingTestCase.class);
        suite.addTestSuite(CharListHeredocParsingTestCase.class);
        suite.addTestSuite(CharListParsingTestCase.class);
        suite.addTestSuite(org.elixir_lang.parser_definition.double_quotes.BodyParsingTestCase.class);
        suite.addTestSuite(org.elixir_lang.parser_definition.double_quotes.YYInitialParsingTestCase.class);
        suite.addTestSuite(org.elixir_lang.parser_definition.triple_double_quotes.BodyParsingTestCase.class);
        suite.addTestSuite(org.elixir_lang.parser_definition.triple_double_quotes.YYInitialParsingTestCase.class);

        return suite;
    }
}
