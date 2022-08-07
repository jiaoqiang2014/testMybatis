package com.jd.testmybatis;

import cn.hutool.http.HtmlUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;

@SpringBootTest
public class TestMybatisApplicationTests {


    @Test
    public void testHtmlUtil() {
        String html = "<p><strong>一、使用场景</strong></p><p>（此处填写什么场景建议使用该模板）</p><p><strong>二、使用方式</strong></p><p>（此处填写使用模板的帮助说明）</p><p><strong>三、注意事项</strong></p><p>（此处填写模板需要注意的特殊注意内容，若无则填写无）</p><p><strong>四、展示效果</strong></p><p>（此处可上传若干前端效果图，若无则填写无）</p><p><br></p><p><img src=%22https://m.360buyimg.com/babel/jfs/t1/142939/40/28255/84754/62e3be13E6fda538f/7b1fc9b320636784.jpg%22></p>";

        String html2 = "<html lang=\"zh-Hans-CN\"><head><meta charset=\"UTF-8\"><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><meta name=\"viewport\" content=\"width=device-width,initial-scale=1\"><link rel=\"icon\" href=\"/favicon.ico\"><title>新标签页 - 极客时间</title><link href=\"/css/override.css\" rel=\"preload\" as=\"style\"><link href=\"/js/override.decc7dfa89a7cd642e3e.js\" rel=\"preload\" as=\"script\"><link href=\"/css/override.css\" rel=\"stylesheet\"></head><body><noscript><strong>We're sorry but 新标签页 - 极客时间 doesn't work properly without JavaScript enabled. Please enable it to continue.</strong></noscript><div id=\"app\"></div><script src=\"/js/override.decc7dfa89a7cd642e3e.js\"></script></body></html>";

        Document document = Jsoup.parse(html2);
        String cleanHtmlres = HtmlUtil.cleanHtmlTag(html);
    }

    /*
     * 获取网页中的所有链接
     * */
    @Test
    public void testJsoupGetLinks() throws IOException {
        Document document = Jsoup.connect("https://www.yiibai.com/jsoup/jsoup-quick-start.html").get();
        // <li><a href="https://www.yiibai.com/html/java/">Java技术</a></li>
        // <li> ... </li> 表示 Element，li 是一个 Tag， <a> ... </a> 是嵌套元素, a 是一个 Tag。
        // <a> 标签定义超链接，用于从一个页面链接到另一个页面。 <a> 元素最重要的属性是 href 属性，它指定链接的目标。
        Elements links = document.select("a[href]");    // "a[href]" 相当于一个正则表达式
        for (Element link : links) {
            System.out.println(link.attr("href"));
            System.out.println(link.text());
        }
    }

    /*
    * 获取HTML页面中的所有图像
    * */
    @Test
    public void testJsoupGetImgs() throws IOException {
        Document document = Jsoup.connect("https://www.yiibai.com/jsoup/jsoup-quick-start.html").get();
        // <img width="150" height="150" src="https://www.yiibai.com/static/img/qrcode.jpg">
        // (?i) 是正则表达式的模式修饰符，(?i)即匹配时不区分大小写。
        Elements images = document.select("img[src~=(?i)\\.(png|jpe?g|gif)]");    // ～表示后面正式开始正则表达式。
        // 是否使用下面的更合理
        // Elements images = document.select("img[src]");
        for (Element image : images) {
            System.out.println("src : " + image.attr("src"));
            System.out.println("height : " + image.attr("height"));
            System.out.println("width : " + image.attr("width"));
            System.out.println("alt : " + image.attr("alt"));
        }
    }


    /*
     * 统计 HTML 中的字数
     * */
    @Test
    public void testJsoupCountWords() throws IOException {
        Document document = Jsoup.connect("https://www.yiibai.com/jsoup/jsoup-quick-start.html").get();
        String html = "<p><strong>    使  用场景</p><p><strong>使  用场景      </p>";
        document = Jsoup.parse(html);
        // 获取此元素及其所有子元素的规范化组合文本(开头末尾的空格回车等被删除)。
        String allText = document.text();
        // text 未被规范化
        String allWholeText = document.wholeText();
        // 只获取当前节点的内容，不获取字节点内容
        String ownText = document.ownText();
    }

    @Test
    public void testString() {

        ArrayList<String> failCurUserNotStyleIdErpBuilder = new ArrayList<>();
        failCurUserNotStyleIdErpBuilder.add("12");
        failCurUserNotStyleIdErpBuilder.add("23");
        StringBuilder msg = new StringBuilder();
        System.out.println(failCurUserNotStyleIdErpBuilder.toString());
    }
}
