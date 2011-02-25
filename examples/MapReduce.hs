-- ------------
-- MapReduce.hs
-- ------------

{-
(>>)     :: IO a          -> IO b          -> IO b -- 'then' operator
assert   :: Bool          -> a             -> a
foldl    :: (a -> b -> a) -> a      -> [b] -> a
putStrLn :: String         -> IO ()
return   :: a              -> IO a
-}

import Control.Exception (assert)
import System.CPUTime    (getCPUTime)

cpms :: Double         -- clocks per millisecond
cpms = 10 ^ (9 :: Int)

square :: Int -> Int
square n = n ^ (2 :: Int)

cube :: Int -> Int
cube n = n ^ (3 :: Int)

map_reduce_1 :: (a -> a -> a) -> (a -> a) -> a -> [a] -> a
map_reduce_1 _  _  v []       = v
map_reduce_1 bf uf v (x : xs) = map_reduce_1 bf uf (bf v (uf x)) xs

map_reduce_2 :: (a -> a -> a) -> (a -> a) -> a -> [a] -> a
map_reduce_2 bf uf v a = foldl bf v (map uf a)

test1 :: ((Int -> Int -> Int) -> (Int -> Int) -> Int -> [Int] -> Int) -> IO ()
test1 f =
    let a :: [Int]
        a = [2, 3, 4]
    in assert ((f (+) square 0 a) ==    29) return () >>
       assert ((f (+) cube   0 a) ==    99) return () >>
       assert ((f (*) square 1 a) ==   576) return () >>
       assert ((f (*) cube   1 a) == 13824) return ()

test2 :: ((Int -> Int -> Int) -> (Int -> Int) -> Int -> [Int] -> Int) -> IO ()
test2 f =
    getCPUTime                                        >>=
    (\s ->
        print f                                   >>
        getCPUTime                                >>=
        (\t ->
            let d :: Double
                d = (fromIntegral (t - s)) / cpms
            in putStr (show d)))                      >>
    putStrLn " milliseconds"                          >>

main :: IO ()
main =
    putStrLn "MapReduce.hs" >>

    test1 map_reduce_1 >>
    test1 map_reduce_2 >>

    test2 map_reduce_1 >>
    test2 map_reduce_2 >>

    putStrLn "Done."
