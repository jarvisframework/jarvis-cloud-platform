package com.jarvis.platform.autoconfigure.license;

import com.jarvis.platform.autoconfigure.license.util.FileUtil;
import com.jarvis.platform.autoconfigure.license.util.LicenceUtil;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.File;

/**
 * @author Doug Wang
 * @since 1.8, 2024-04-16 10:20:36
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnWebApplication
public class JarvisLicenseAutoConfiguration implements ApplicationRunner {


    @Override
    public void run(ApplicationArguments args) throws Exception {
        new ClassPathResource("");
        String path;
        try {
            path = (new File("/home/pcs/lic1.license")).getAbsolutePath();
            System.out.println(path);
            String licStr = FileUtil.readFileContent(path);
            boolean b = LicenceUtil.checkLicenceValid(licStr);
            if (b) {
                System.out.println("lic valid");
            } else {
                System.out.println("lic invalid");
                System.exit(0);
            }
        } catch (Exception var6) {
            var6.printStackTrace();
            System.out.println("证书无效");
            System.exit(0);
        }
    }

}
