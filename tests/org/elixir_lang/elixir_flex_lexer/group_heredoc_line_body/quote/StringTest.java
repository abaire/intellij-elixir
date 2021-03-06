package org.elixir_lang.elixir_flex_lexer.group_heredoc_line_body.quote;

import com.intellij.psi.tree.IElementType;
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
public class StringTest extends PromoterTest {
    @Override
    protected IElementType fragmentType() {
        return ElixirTypes.STRING_FRAGMENT;
    }

    @Override
    protected String promoter() {
        return "\"\"\"";
    }
}
