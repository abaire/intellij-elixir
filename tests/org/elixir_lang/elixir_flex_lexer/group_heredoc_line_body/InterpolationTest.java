package org.elixir_lang.elixir_flex_lexer.group_heredoc_line_body;

import org.elixir_lang.ElixirFlexLexer;
import org.elixir_lang.psi.ElixirTypes;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

import static org.junit.Assert.assertEquals;

/**
 * Created by luke.imhoff on 9/2/14.
 */
public class InterpolationTest extends org.elixir_lang.elixir_flex_lexer.Test {
    @Override
    protected void reset(CharSequence charSequence) throws IOException {
        // start to trigger GROUP state with isInterpolating being true
        CharSequence fullCharSequence = "\"\"\"\n" + charSequence;
        super.reset(fullCharSequence);
        // consume "\"\"\""
        flexLexer.advance();
        // consume '\n'
        flexLexer.advance();
    }

    @Test
    public void hashBrace() throws IOException {
        reset("#{");

        assertEquals(ElixirTypes.INTERPOLATION_START, flexLexer.advance());
        assertEquals(ElixirFlexLexer.INTERPOLATION, flexLexer.yystate());
    }

    @Test
    public void escapedDoubleQuotes() throws IOException {
        reset("\\\"");

        assertEquals(ElixirTypes.VALID_ESCAPE_SEQUENCE, flexLexer.advance());
        assertEquals(ElixirFlexLexer.GROUP_HEREDOC_LINE_BODY, flexLexer.yystate());
    }

    @Test
    public void escapedSingleQuotes() throws IOException {
        reset("\\'");

        assertEquals(ElixirTypes.VALID_ESCAPE_SEQUENCE, flexLexer.advance());
        assertEquals(ElixirFlexLexer.GROUP_HEREDOC_LINE_BODY, flexLexer.yystate());
    }

    @Test
    public void escapedInterpolationState() throws IOException {
        reset("\\#{");

        assertEquals(ElixirTypes.VALID_ESCAPE_SEQUENCE, flexLexer.advance());
        assertEquals(ElixirFlexLexer.GROUP_HEREDOC_LINE_BODY, flexLexer.yystate());
    }
}
