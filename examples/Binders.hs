-- ----------
-- Binders.hs
-- ----------

{-
(>>)     :: IO a          -> IO b      -> IO b -- 'then' operator
(-)      :: a             -> a         -> a
assert   :: Bool          -> a         -> a
flip     :: (a -> b -> c) -> b    -> a -> c
putStrLn :: String                     -> IO ()
return   :: a                          -> IO a
-}

import Control.Exception (assert)

main :: IO ()
main =
    putStrLn "Binders.hs" >>

    let f :: Int -> Int
        f = (-) (3::Int)
    in assert (f 2 == 1) return () >>

    let g :: Int -> Int
        g = (flip (-)) (3::Int)
    in assert (g 2 == -1) return () >>

    putStrLn "Done."
