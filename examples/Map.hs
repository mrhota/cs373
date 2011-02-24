-- ------
-- Map.hs
-- ------

{-
(>>)     :: IO a     -> IO b -> IO b -- 'then' operator
assert   :: Bool     -> a    -> a
map      :: (a -> b) -> [a]  -> [b]
putStrLn :: String           -> IO ()
return   :: a                -> IO a
-}

import Control.Exception (assert)

square :: Int -> Int
square n = n ^ (2 :: Int)

cube :: Int -> Int
cube n = n ^ (3 :: Int)

map_1 :: (a -> b) -> [a] -> [b]
map_1 _  []       = []
map_1 uf (x : xs) = uf x : map_1 uf xs

map_2 :: (a -> b) -> [a] -> [b]
map_2 uf a = [uf v | v <- a]

test :: ((Int -> Int) -> [Int] -> [Int]) -> IO ()
test f =
    let a, b, c :: [Int]
        a = [2,  3,  4]
        b = [4,  9, 16]
        c = [8, 27, 64]
    in assert ((f square a) == b) return () >>
       assert ((f cube   a) == c) return ()

main :: IO ()
main =
    putStrLn "Map.hs" >>

    test map   >>
    test map_1 >>
    test map_2 >>

    putStrLn "Done."
