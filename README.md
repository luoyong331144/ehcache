#### pom.xml
``` xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>name.luoyong.cache</groupId>
	<artifactId>ehcache-example</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>

	<name>ehcache-example</name>

	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
	</properties>

	<dependencies>

		<dependency>
			<groupId>net.sf.ehcache</groupId>
			<artifactId>ehcache</artifactId>
			<version>2.8.3</version>
		</dependency>

	</dependencies>
</project>
```
#### ehcache.xml
``` xml
<?xml version="1.0" encoding="UTF-8"?>

<ehcache name="ColorCache">

	<diskStore path="java.io.tmpdir"/>

  <cache name="userCache"
         maxElementsInMemory="10"
         maxElementsOnDisk="0"
         eternal="false"
         timeToIdleSeconds="2"
         timeToLiveSeconds="3">
  </cache>
  
</ehcache>
```

#### java test
``` java
	public static void main(String[] args) throws Exception {
		CacheManager cacheManager = CacheManager.create();
		Cache userCache = cacheManager.getCache("userCache");
		
		Element luoyong = new Element("luoyong", new User("罗勇"));
		
		userCache.put(luoyong);
		
		for(int i=0; i<3; i++) {
			Thread.sleep(1300);
			Element luoyongElement = userCache.get("luoyong");
			if(luoyongElement == null) {
				System.out.println("lyElement is not in userCache now");
				System.exit(0);
			}
			User ly = (User)luoyongElement.getObjectValue();
			System.out.println(ly.getName());
		}
	}
```