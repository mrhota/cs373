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

map1 :: (a -> a) -> [a] -> [a]
map1 _  []       = []
map1 uf (x : xs) = uf x : map1 uf xs

map2 :: (a -> a) -> [a] -> [a]
map2 uf a = [uf v | v <- a]

test :: ((Int -> Int) -> [Int] -> [Int]) -> IO ()
test f =
    let a, b, c :: [Int]
        a = [2,  3,  4]
        b = [4,  9, 16]
        c = [8, 27, 64]
    in assert ((f ((flip (^)) (2 :: Int)) a) == b) return () >>
       assert ((f ((flip (^)) (3 :: Int)) a) == c) return ()

main :: IO ()
main =
    putStrLn "Map.hs" >>

    test map  >>
    test map1 >>
    test map2 >>

    putStrLn "Done."
