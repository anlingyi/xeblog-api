package cn.xeblog.api.util;

import org.apache.commons.lang3.StringUtils;
import org.commonmark.Extension;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.node.*;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author anlingyi
 * @date 2021/11/20 3:25 下午
 */
public class MarkdownUtils {

    private static final List<Extension> extensions = Arrays.asList(TablesExtension.create());

    /**
     * markdown转html
     *
     * @param content
     * @return
     */
    public static String toHtml(String content) {
        HtmlRenderer renderer = HtmlRenderer.builder()
                .extensions(extensions)
                .build();
        return renderer.render(getNode(content));
    }

    /**
     * 获取AST
     *
     * @param content
     * @return
     */
    private static Node getNode(String content) {
        Parser parser = Parser.builder()
                .extensions(extensions)
                .build();
        return parser.parse(content);
    }

    /**
     * 统计markdown文档字数
     *
     * @param content
     * @return
     */
    public static int getWordCount(String content) {
        AtomicInteger count = new AtomicInteger();
        Node node = getNode(content);
        node.accept(new AbstractVisitor() {
            @Override
            public void visit(Text text) {
                super.visit(text);
                if (text.getParent() instanceof Image) {
                    return;
                }

                counter(text.getLiteral());
            }

            @Override
            public void visit(Code code) {
                super.visit(code);
                counter(code.getLiteral());
            }

            @Override
            public void visit(FencedCodeBlock fencedCodeBlock) {
                super.visit(fencedCodeBlock);
                counter(fencedCodeBlock.getLiteral());
            }

            private void counter(String text) {
                if (StringUtils.isBlank(text)) {
                    return;
                }

                count.addAndGet(text.replaceAll("\\s*", "").length());
            }
        });

        return count.get();
    }

}
