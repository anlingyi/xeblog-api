package cn.xeblog.api.domain.bo;

import cn.xeblog.api.domain.dto.ArticleDetailsDTO;
import cn.xeblog.api.domain.dto.ArticleNavDTO;

/**
 * 文章详情
 *
 * @author yanpanyi
 * @date 2018/10/8
 */
public class ArticleDetailsBO {
    /**
     * 文章详情
     */
    private ArticleDetailsDTO articleDetailsDTO;
    /**
     * 上一篇
     */
    private ArticleNavDTO previous;
    /**
     * 下一篇
     */
    private ArticleNavDTO next;

    public ArticleDetailsBO() {
    }

    public ArticleDetailsBO(ArticleDetailsDTO articleDetailsDTO, ArticleNavDTO previous, ArticleNavDTO next) {
        this.articleDetailsDTO = articleDetailsDTO;
        this.previous = previous;
        this.next = next;
    }

    public ArticleDetailsDTO getArticleDetailsDTO() {
        return articleDetailsDTO;
    }

    public void setArticleDetailsDTO(ArticleDetailsDTO articleDetailsDTO) {
        this.articleDetailsDTO = articleDetailsDTO;
    }

    public ArticleNavDTO getPrevious() {
        return previous;
    }

    public void setPrevious(ArticleNavDTO previous) {
        this.previous = previous;
    }

    public ArticleNavDTO getNext() {
        return next;
    }

    public void setNext(ArticleNavDTO next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "ArticleDetailsBO{" +
                "articleDetailsDTO=" + articleDetailsDTO +
                ", previous=" + previous +
                ", next=" + next +
                '}';
    }
}
