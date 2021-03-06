package org.elixir_lang.elixir_flex_lexer.group_heredoc_line_start.sigil;

import com.intellij.psi.TokenType;
import org.elixir_lang.ElixirFlexLexer;
import org.elixir_lang.psi.ElixirTypes;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

import static org.junit.Assert.assertEquals;

/**
 * Created by luke.imhoff on 9/3/14.
 */
public class CharListTest extends org.elixir_lang.elixir_flex_lexer.Test {
    @Override
    protected void reset(CharSequence charSequence) throws IOException {
        // start to trigger GROUP state
        CharSequence fullCharSequence = "~c'''\n" + charSequence;
        super.reset(fullCharSequence);
        // consume '~'
        flexLexer.advance();
        // consume 'c'
        flexLexer.advance();
        // consume "'''"
        flexLexer.advance();
        // consume '\n'
        flexLexer.advance();
    }

    @Test
    public void spaceTripleSingleQuotes() throws IOException {
        reset(" '''");

        assertEquals(TokenType.WHITE_SPACE, flexLexer.advance());
        assertEquals(ElixirFlexLexer.GROUP_HEREDOC_END, flexLexer.yystate());
    }

    @Test
    public void tabTripleSingleQuotes() throws IOException {
       reset("\t'''");

        assertEquals(TokenType.WHITE_SPACE, flexLexer.advance());
        assertEquals(ElixirFlexLexer.GROUP_HEREDOC_END, flexLexer.yystate());
    }

    @Test
    public void formFeedTripleSingleQuotes() throws IOException {
        reset("\f'''");

        assertEquals(TokenType.WHITE_SPACE, flexLexer.advance());
        assertEquals(ElixirFlexLexer.GROUP_HEREDOC_END, flexLexer.yystate());
    }

    @Test
    public void spaceTripleDoubleQuotes() throws IOException {
        reset(" \"\"\"");

        assertEquals(TokenType.WHITE_SPACE, flexLexer.advance());
        assertEquals(ElixirFlexLexer.GROUP_HEREDOC_END, flexLexer.yystate());
    }

    @Test
    public void tabTripleDoubleQuotes() throws IOException {
        reset("\t\"\"\"");

        assertEquals(TokenType.WHITE_SPACE, flexLexer.advance());
        assertEquals(ElixirFlexLexer.GROUP_HEREDOC_END, flexLexer.yystate());
    }

    @Test
    public void formFeedTripleDoubleQuotes() throws IOException {
        reset("\f\"\"\"");

        assertEquals(TokenType.WHITE_SPACE, flexLexer.advance());
        assertEquals(ElixirFlexLexer.GROUP_HEREDOC_END, flexLexer.yystate());
    }

    @Test
    public void tripleSingleQuotes() throws IOException {
        reset("'''");

        assertEquals(ElixirTypes.CHAR_LIST_SIGIL_HEREDOC_TERMINATOR, flexLexer.advance());
        assertEquals(ElixirFlexLexer.SIGIL_MODIFIERS, flexLexer.yystate());
    }

    @Test
    public void tripleDoubleQuotes() throws IOException {
        reset("\"\"\"");

        assertEquals(ElixirTypes.CHAR_LIST_FRAGMENT, flexLexer.advance());
        assertEquals(ElixirFlexLexer.GROUP_HEREDOC_LINE_BODY, flexLexer.yystate());
    }

    @Test
    public void eol() throws IOException {
        reset("\n");

        assertEquals(ElixirTypes.CHAR_LIST_FRAGMENT, flexLexer.advance());
        assertEquals(ElixirFlexLexer.GROUP_HEREDOC_LINE_START, flexLexer.yystate());
    }

    @Test
    public void character() throws IOException {
        reset("a");

        assertEquals(ElixirTypes.CHAR_LIST_FRAGMENT, flexLexer.advance());
        assertEquals(ElixirFlexLexer.GROUP_HEREDOC_LINE_BODY, flexLexer.yystate());
    }
}
