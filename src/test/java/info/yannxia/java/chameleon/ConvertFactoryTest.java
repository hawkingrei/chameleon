package info.yannxia.java.chameleon;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by yann on 2016/11/30.
 */
public class ConvertFactoryTest {

    @Test
    public void convert() throws Exception {
        ConvertFactory convertFactory = ConvertFactoryImpl.build(new ConvertTestService());

        ConvertTestService.A a = new ConvertTestService.A();
        a.name = "a";

        ConvertTestService.B b = convertFactory.convert(ConvertTestService.B.class, a);
        Assert.assertEquals(a.name, b.name);
        b.name = "b";

        ConvertTestService.C c = convertFactory.convert(ConvertTestService.C.class, a, b);
        Assert.assertEquals(c.aName, a.name);
        Assert.assertEquals(c.bName, b.name);

    }

    @Test(expected = IllegalArgumentException.class)
    public void test_error_covert_build(){
        ConvertFactory convertFactory = ConvertFactoryImpl.build(
                new ConvertTestService(), new ConvertTestService());
    }

}

