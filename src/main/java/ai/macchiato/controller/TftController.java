package ai.macchiato.controller;
import ai.macchiato.service.TFTCrawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class TftController {

    private int i = 0;//非静态


    @Autowired
    private TFTCrawler crawler;

    @Autowired
    private TestClass1 t1;


    @Autowired
    private TestClass2 t2;


    @RequestMapping("/")
    public String index() {

        System.out.println(t2.test());
        System.out.println(t1.test());
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/show")
    public String toShow() {
        System.out.println(++i);
        return"show";
    }
    @RequestMapping("/test")
    public String test() {
        System.out.println(++i);
        return"test";
    }
}
