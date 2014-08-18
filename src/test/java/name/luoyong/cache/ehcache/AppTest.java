package name.luoyong.cache.ehcache;

import junit.framework.TestCase;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class AppTest extends TestCase  {

	
	public void testEhcache() throws Exception {
		System.out.println("***************** begin test *******************");
		App.main(null);
		System.out.println("***************** end   test *******************");
	}
}

