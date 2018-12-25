package swagger2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableSwagger2
@ServletComponentScan
public class SpringBootSwagger2RunClazz
{
    public static void main( String[] args )
    {
        SpringApplication.run(SpringBootSwagger2RunClazz.class);
    }

}
