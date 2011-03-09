-- ------------
-- Factorial.hs
-- ------------

{-
(>>)     :: IO a          -> IO b        -> IO b  -- 'then' operator
assert   :: Bool          -> a           -> a
foldl    :: (a -> b -> a) -> a    -> [b] -> a
product  :: [a]                          -> a
putStrLn :: String                       -> IO ()
return   :: a                            -> IO a
-}

import Control.Exception (assert)

factorial1 :: Int -> Int
factorial1 n =
    if n == 0 then
        1
    else
        n * factorial1 (n - 1)

factorial2 :: Int -> Int
factorial2 0 = 1
factorial2 n = n * factorial2 (n - 1)

factorial3 :: Int -> Int
factorial3 n
    | n == 0    = 1
    | otherwise = n * factorial3 (n - 1)

factorial4 :: Int -> Int
factorial4 n = foldl (*) 1 [1..n]

factorial5 :: Int -> Int
factorial5 n = product [1..n]

test :: (Int -> Int) -> IO ()
test f =
    assert ((f 0) ==   1) return () >>
    assert ((f 1) ==   1) return () >>
    assert ((f 2) ==   2) return () >>
    assert ((f 3) ==   6) return () >>
    assert ((f 4) ==  24) return () >>
    assert ((f 5) == 120) return ()

main :: IO ()
main =
    putStrLn "Factorial.hs" >>

    test factorial1 >>
    test factorial2 >>
    test factorial3 >>
    test factorial4 >>
    test factorial5 >>

    putStrLn "Done."
