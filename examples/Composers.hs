-- ------------
-- Composers.hs
-- ------------

{-
(>>)     :: IO a          -> IO b      -> IO b -- 'then' operator
assert   :: Bool          -> a         -> a
flip     :: (a -> b -> c) -> b    -> a -> c
putStrLn :: String                     -> IO ()
return   :: a                          -> IO a
-}

import Control.Exception (assert)

main :: IO ()
main =
    putStrLn "Composers.hs" >>

    let f :: Int -> Int
        f = (+) 1 . (*) 3
    in assert (f 5 == 16) return () >>

    putStrLn "Done."
