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

map_reduce_1 :: (a -> a -> a) -> (a -> a) -> a -> [a] -> a
map_reduce_1 bf uf v a = foldl bf v (map uf a)

map_reduce_2 :: (a -> a -> a) -> (a -> a) -> a -> [a] -> a
map_reduce_2 _  _  v []       = v
map_reduce_2 bf uf v (x : xs) = map_reduce_2 bf uf (bf v (uf x)) xs

test1 :: ((Int -> Int -> Int) -> (Int -> Int) -> Int -> [Int] -> Int) -> IO ()
test1 f =
    let a :: [Int]
        a = [2, 3, 4]
    in assert ((f (+) ((flip (^)) (2 :: Int)) 0 a) ==    29) return () >>
       assert ((f (+) ((flip (^)) (3 :: Int)) 0 a) ==    99) return () >>
       assert ((f (*) ((flip (^)) (2 :: Int)) 1 a) ==   576) return () >>
       assert ((f (*) ((flip (^)) (3 :: Int)) 1 a) == 13824) return ()

test2 :: ((Int -> Int -> Int) -> (Int -> Int) -> Int -> [Int] -> Int) -> IO ()
test2 f =
    let a :: [Int]
        a = replicate 100000 1
    in getCPUTime >>=
       (\s ->
           print (f (+) ((flip (^)) (2 :: Int)) 0 a) >>
           print (f (+) ((flip (^)) (3 :: Int)) 0 a) >>
           print (f (*) ((flip (^)) (2 :: Int)) 1 a) >>
           print (f (*) ((flip (^)) (3 :: Int)) 1 a) >>
           getCPUTime               >>=
           (\t ->
               let d :: Double
                   d = (fromIntegral (t - s)) / cpms
               in putStr (show d))) >>
       putStrLn " milliseconds"

main :: IO ()
main =
    putStrLn "MapReduce.hs" >>

    test1 map_reduce_1 >>
    test1 map_reduce_2 >>
    putStrLn ""        >>

    putStrLn "map_reduce_1" >>
    test2 map_reduce_1      >>
    putStrLn ""             >>

    putStrLn "map_reduce_2" >>
    test2 map_reduce_2      >>
    putStrLn ""             >>

    putStrLn "Done."

{-
Glasgow Haskell Compiler, Version 6.12.1, for Haskell 98, stage 2 booted by GHC version 6.10.4

MapReduce.hs

map_reduce_1
100000
100000
1
1
245.496 milliseconds

map_reduce_2
100000
100000
1
1
276.291 milliseconds

Done.
-}

{-
Glasgow Haskell Compiler, Version 6.12.1, for Haskell 98, stage 2 booted by GHC version 6.12.1

MapReduce.hs

map_reduce_1
100000
100000
1
1
236.015 milliseconds

map_reduce_2
100000
100000
1
1
252.015 milliseconds

Done.
-}
