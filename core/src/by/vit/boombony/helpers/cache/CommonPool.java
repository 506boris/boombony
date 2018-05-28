//package by.vit.boombony.helpers.cache;
//
//public class CommonPool {
//    private static IEntity ballLevel;
//
//    public static void initCache(IEntity ballLevel) {
//        ExplosionCache.ballLevel = ballLevel;
//        explosionBall.reset();
//    }
//
//    public static ExplosionBall getBall() {
//        return explosionBall.obtainPoolItem();
//    }
//
//    public static void putBall(ExplosionBall ball) {
//        explosionBall.recyclePoolItem(ball);
//    }
//
//    private static final GenericPool<ExplosionBall> explosionBall = new GenericPool<ExplosionBall>() {
//        @Override
//        protected ExplosionBall onAllocatePoolItem() {
//            return new ExplosionBall(ballLevel);
//        }
//    };
//}
//}
