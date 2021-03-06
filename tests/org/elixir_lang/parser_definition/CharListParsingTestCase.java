package org.elixir_lang.parser_definition;

/**
 * Created by luke.imhoff on 8/7/14.
 */
public class CharListParsingTestCase extends ParsingTestCase {
    public void testEmpty() {
        doTest(true);
    }

    public void testEscapeSequences() {
        doTest(true);
    }

    public void testInterpolation() {
        doTest(true);
    }

    public void testMultiline() {
        doTest(true);
    }

    @Override
    protected String getTestDataPath() {
        return super.getTestDataPath() + "/char_list_parsing_test_case";
    }
}
