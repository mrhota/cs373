-- -------------
-- SumSquares.hs
-- -------------

{-
(>>)     :: IO a     -> IO b     -> IO b  -- 'then' operator
(+)      :: a             -> a          -> a
(^)      :: a             -> b          -> a
(.)      :: (b -> c) -> (a -> b) -> a -> c
assert   :: Bool     -> a        -> a
foldl    :: (a -> b -> a) -> a   -> [b] -> a
flip     :: (a -> b -> c) -> b   -> a   -> c
map      :: (a -> b) -> [a]      -> [b]
putStrLn :: String               -> IO ()
sum      :: [a]                  -> a
return   :: a                    -> IO a
-}

import Control.Exception (assert)
import System.CPUTime    (getCPUTime)

cpms :: Double         -- clocks per millisecond
cpms = 10 ^ (9 :: Int)

sum_squares_1 :: [Int] -> Int
sum_squares_1 a = foldl (+) 0 (map ((flip (^)) (2::Int)) a)

sum_squares_2 :: [Int] -> Int
sum_squares_2 a = sum (map ((flip (^)) (2::Int)) a)

sum_squares_3 :: [Int] -> Int
sum_squares_3 = sum . (map ((flip (^)) (2::Int)))

test1 :: (([Int] -> Int)) -> IO ()
test1 f =
    let a :: [Int]
        a = [2, 3, 4]
    in assert ((f a) == 29) return ()

test2 :: (([Int] -> Int)) -> IO ()
test2 f =
    let a :: [Int]
        a = replicate 100000 1
    in getCPUTime >>=
       (\s ->
           print (f a) >>
           getCPUTime  >>=
           (\t ->
               let d :: Double
                   d = (fromIntegral (t - s)) / cpms
               in putStr (show d))) >>
       putStrLn " milliseconds"

main :: IO ()
main =
    putStrLn "SumSquares.hs" >>

    test1 sum_squares_1 >>
    test1 sum_squares_2 >>
    test1 sum_squares_3 >>
    putStrLn ""         >>

    putStrLn "sum_squares_1" >>
    test2 sum_squares_1      >>
    putStrLn ""              >>

    putStrLn "sum_squares_2" >>
    test2 sum_squares_2      >>
    putStrLn ""              >>

    putStrLn "sum_squares_3" >>
    test2 sum_squares_3      >>
    putStrLn ""              >>

    putStrLn "Done."

{-
Glasgow Haskell Compiler, Version 6.12.1, for Haskell 98, stage 2 booted by GHC version 6.10.4

SumSquares.hs

sum_squares_1
100000
75.878 milliseconds

sum_squares_2
100000
63.83 milliseconds

sum_squares_3
100000
58.975 milliseconds

Done.
-}

{-
Glasgow Haskell Compiler, Version 6.12.1, for Haskell 98, stage 2 booted by GHC version 6.12.1

SumSquares.hs

sum_squares_1
100000
60.003 milliseconds

sum_squares_2
100000
56.003 milliseconds

sum_squares_3
100000
56.004 milliseconds

Done.
-}
