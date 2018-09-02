package es;

import com.jcohy.study.elasticsearch.Book;
import com.jcohy.study.elasticsearch.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by jiac on 2018/9/2.
 * ClassName  : es
 * Description  :
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ESTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void test2(){
        Book book = new Book();
        book.setId(1);
        book.setName("jcohy");
        book.setAuthor("jcohy");
        bookRepository.index(book);
    }

//    @Autowired
//    private JestClient jestClient;
////
////     @Test
////    public void contextLoad(){
////         //给ES中索引保存一个文档
////         Article article = new Article();
////         //setter
////         //构建一个索引功能
////         Index index = new Index.Builder(article).index("jcohy").type("news").build();
////         try {
////             //执行
////             jestClient.execute(index);
////         } catch (IOException e) {
////             e.printStackTrace();
////         }
////     }
//
//     //测试搜索
//     @Test
//     public void search(){
//         String json = "";
//         //构建搜索功能
//         Search search = new Search.Builder(json).addIndex("jcohy").addType("news").build();
//         //执行
//         try {
//             SearchResult searchResult = jestClient.execute(search);
//             System.out.println(searchResult.getJsonString());
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }
}
