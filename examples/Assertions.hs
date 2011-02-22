-- -------------
-- Assertions.hs
-- -------------

{-
Turn OFF assertions at compile time with -fignore-asserts or -O
% ghc -fignore-asserts -Wall Assertions.hs -o Assertions.hs.app
% ghc -O               -Wall Assertions.hs -o Assertions.hs.app
% Assertions.hs.app
-}

{-
(>>)     :: IO a   -> IO b -> IO b  -- 'then' operator
assert   :: Bool   -> a    -> a
putStrLn :: String         -> IO ()
return   :: a              -> IO a
-}

import Control.Exception (assert)

inc :: Int -> Int
inc i = i + 1

main :: IO ()
main =
    putStrLn "Assertions.hs"        >>
    assert ((inc 2) == 3) return () >>
    assert ((inc 2) == 4) return () >>
    putStrLn "Done."

{-
Assertions.hs
Assertions.hs.app: Assertions.hs:28:4-9: Assertion failed
-}
