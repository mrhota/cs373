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

map1 :: (a -> b) -> [a] -> [b]
map1 _  []       = []
map1 uf (x : xs) = uf x : map1 uf xs

map2 :: (a -> b) -> [a] -> [b]
map2 uf a = [uf v | v <- a]

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
    test map1 >>
    test map2 >>

    putStrLn "Done."
