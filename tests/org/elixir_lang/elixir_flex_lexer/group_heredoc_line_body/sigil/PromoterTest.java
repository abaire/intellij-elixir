package org.elixir_lang.elixir_flex_lexer.group_heredoc_line_body.sigil;

import com.intellij.psi.tree.IElementType;
import org.elixir_lang.ElixirFlexLexer;
import org.elixir_lang.elixir_flex_lexer.group_heredoc_line_body.GroupTest;
import org.elixir_lang.psi.ElixirTypes;
import org.jetbrains.annotations.NotNull;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

import static org.junit.Assert.assertEquals;

/**
 * Created by luke.imhoff on 9/6/14.
 */
public abstract class PromoterTest extends GroupTest {
    protected void reset(CharSequence charSequence) throws IOException {
        // start to trigger GROUP state
        CharSequence fullCharSequence = "~" + sigilName() + "'''\n" + charSequence;
        super.reset(fullCharSequence);
        // consume '~'
        flexLexer.advance();
        // consume sigilName
        flexLexer.advance();
        // consume "'''"
        flexLexer.advance();
        // consume '\n'
        flexLexer.advance();
    }

    protected abstract char sigilName();

    @Test
    public void eol() throws IOException {
        reset("\n");

        assertEquals(fragmentType(), flexLexer.advance());
        assertEquals(ElixirFlexLexer.GROUP_HEREDOC_LINE_START, flexLexer.yystate());
    }

    @Test
    public void character() throws IOException {
        reset("a");

        assertEquals(fragmentType(), flexLexer.advance());
        assertEquals(ElixirFlexLexer.GROUP_HEREDOC_LINE_BODY, flexLexer.yystate());
    }
}
