package practice;

//import java.util.ArrayList;

//import org.easymock.EasyMock;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
//import com.bioware.cerberus.ecommerce.domain.CatalogOffers;
//import com.bioware.cerberus.ecommerce.impl.CatalogOffersCache;
//import com.bioware.cerberus.ecommerce.impl.ECommerceServiceImpl;
//import com.bioware.cerberus.ecommerce.ofb.OfbClient;
//import com.bioware.cerberus.ecommerce.ofb.domain.OfbProduct;
//import com.bioware.cerberus.ecommerce.ofb.domain.OfbProducts;

//public class TestCatalogOfferCaching {
//
//    private OfbClient ofbClient;
//    private long timeToLiveInCache;
//    private ECommerceServiceImpl eCommerceServiceImpl;
//    private CatalogOffersCache cache;
//
//    @Before
//    public void setUp() throws Exception {
//
//        ofbClient = EasyMock.createMock(OfbClient.class);
//        timeToLiveInCache = 20000;
//        eCommerceServiceImpl = new ECommerceServiceImpl();
//        cache = EasyMock.createMock(CatalogOffersCache.class);
//        eCommerceServiceImpl.setCache(cache);
//        eCommerceServiceImpl.setTimeToLiveInCache(timeToLiveInCache);
//        eCommerceServiceImpl.setOfbClient(ofbClient);
//    }
//
//    @Test
//    public void getOfbProductsFromCacheBeforeTheCacheGetsExpired() {
//
//        final String categoryId = "22177";
//        final String gameId = "DKS";
//        final OfbProducts products = new OfbProducts();
//
//        products.productList = new ArrayList<OfbProduct>();
//
//        OfbProduct product = new OfbProduct();
//
//        products.productList.add(product);
//
//        EasyMock.expect(cache.getOffersFromCache(categoryId, timeToLiveInCache, true))
//                .andReturn(null).times(2);
//        EasyMock.expect(ofbClient.getOfbProductsByCategoryId(categoryId, true))
//                .andReturn(products);
//        // We need to put the objects which are equal in types as we are not
//        // overriding equals method of CatalogOffers. passing new CatalogOffers
//        // won't help here as easymock will try to match the two catalogOffers
//        // using ==
//        cache.putOffersInCache(EasyMock.eq(categoryId),
//                EasyMock.anyObject(CatalogOffers.class),EasyMock.eq(true));
//        EasyMock.expectLastCall();
//        EasyMock.expect(cache.getOffersFromCache(categoryId, timeToLiveInCache, true))
//                .andReturn(products.toCatalogOffers()).atLeastOnce();
//        EasyMock.replay(cache, ofbClient);
//
//        CatalogOffers offers = eCommerceServiceImpl.getOfbProductsByCategoryId(
//                categoryId, gameId, true);
//        Assert.assertNotNull(offers);
//        offers = eCommerceServiceImpl.getOfbProductsByCategoryId(categoryId,
//                gameId, true);
//        Assert.assertNotNull(offers);
//        offers = eCommerceServiceImpl.getOfbProductsByCategoryId(categoryId,
//                gameId, true);
//        Assert.assertNotNull(offers);
//
//        EasyMock.verify(cache, ofbClient);
//    }
//    
//    @Test
//    public void getOfbProductsFromCacheAfterTheCacheGetsExpired() {
//
//        final String categoryId = "22177";
//        final String gameId = "DKS";
//        final OfbProducts products = new OfbProducts();
//
//        products.productList = new ArrayList<OfbProduct>();
//
//        OfbProduct product = new OfbProduct();
//
//        products.productList.add(product);
//
//        EasyMock.expect(cache.getOffersFromCache(categoryId, timeToLiveInCache,true))
//                .andReturn(null).times(2);
//        EasyMock.expect(ofbClient.getOfbProductsByCategoryId(categoryId, true))
//                .andReturn(products);
//        // We need to put the objects which are equal in types as we are not
//        // overriding equals method of CatalogOffers. passing new CatalogOffers
//        // won't help here as easymock will try to match the two catalogOffers
//        // using ==
//        cache.putOffersInCache(EasyMock.eq(categoryId),
//                EasyMock.anyObject(CatalogOffers.class), EasyMock.eq(true));
//        EasyMock.expectLastCall();
//        EasyMock.expect(cache.getOffersFromCache(categoryId, timeToLiveInCache, true))
//                .andReturn(products.toCatalogOffers()).atLeastOnce();
//        EasyMock.replay(cache, ofbClient);
//
//        CatalogOffers offers = eCommerceServiceImpl.getOfbProductsByCategoryId(
//                categoryId, gameId, true);
//        Assert.assertNotNull(offers);
//        offers = eCommerceServiceImpl.getOfbProductsByCategoryId(categoryId,
//                gameId, true);
//        Assert.assertNotNull(offers);
//        offers = eCommerceServiceImpl.getOfbProductsByCategoryId(categoryId,
//                gameId, true);
//        Assert.assertNotNull(offers);
//        
//        //Ask the test to wait for few seconds.
//        
//        try {
//            
//            Thread.sleep(20000);
//        } catch (InterruptedException e) {
//            
//            e.printStackTrace();
//        }
//        
//        offers = eCommerceServiceImpl.getOfbProductsByCategoryId(categoryId,
//                gameId, true);
//        Assert.assertNotNull(offers);
//        
//        offers = eCommerceServiceImpl.getOfbProductsByCategoryId(categoryId,
//                gameId, true);
//        Assert.assertNotNull(offers);
//
//        EasyMock.verify(cache, ofbClient);
//    }
//}