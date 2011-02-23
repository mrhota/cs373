-- ------
-- Map.hs
-- ------

{-
(>>)     :: IO a     -> IO b -> IO b -- 'then' operator
assert   :: Bool     -> a    -> a
map      :: (a -> b) -> [a]  -> [b]
putStrLn :: String           -> IO ()
sqrt     :: a                -> a
return   :: a                -> IO a
-}

import Control.Exception (assert)

map_1 :: (a -> b) -> [a] -> [b]
map_1 _  []       = []
map_1 uf (x : xs) = uf x : map_1 uf xs

map_2 :: (a -> b) -> [a] -> [b]
map_2 uf a = [uf v | v <- a]

test :: ((Double -> Double) -> [Double] -> [Double]) -> IO ()
test f =
    let x, y, z :: [Double]
        x = []
        y = [4, 9, 16]
        z = [2, 3,  4]

    in assert ((f sqrt x) == x) return () >>
       assert ((f sqrt y) == z) return ()

main :: IO ()
main =
    putStrLn "Map.hs" >>

    test map   >>
    test map_1 >>
    test map_2 >>

    putStrLn "Done."
