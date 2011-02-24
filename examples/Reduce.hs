-- --------
-- Foldl.hs
-- --------

{-
(>>)     :: IO a          -> IO b          -> IO b -- 'then' operator
assert   :: Bool          -> a             -> a
foldl    :: (a -> b -> a) -> a      -> [b] -> a
putStrLn :: String         -> IO ()
return   :: a              -> IO a
-}

import Control.Exception (assert)

reduce :: (a -> b -> a) -> a -> [b] -> a
reduce _  v []       = v
reduce bf v (x : xs) = reduce bf (bf v x) xs

test :: ((Int -> Int -> Int) -> Int -> [Int] -> Int) -> IO ()
test f =
    let a :: [Int]
        a = [2, 3, 4]
    in assert ((f (+) 0 a) ==  9) return () >>
       assert ((f (*) 1 a) == 24) return ()

main :: IO ()
main =
    putStrLn "Foldl.hs" >>

    test foldl  >>
    test reduce >>

    putStrLn "Done."
