-- -------------
-- Exceptions.hs
-- -------------

{-
(>>)     :: IO a   -> IO b        -> IO b  -- 'then' operator
assert   :: Bool   -> a           -> a
catch    :: IO a   -> (e -> IO a) -> IO a
error    :: [Char]                -> a
putStrLn :: String                -> IO ()
return   :: a                     -> IO a
-}

import Control.Exception (assert, catch, SomeException)

f :: Bool -> Int
f False = 0
f True  = error "abc"

handler :: SomeException -> IO ()
handler e = assert ((show e) == "abc") return ()

main :: IO ()
main =
    putStrLn "Exceptions.hs"                                            >>
    Control.Exception.catch (assert ((f False) == 0) return ()) handler >>
    Control.Exception.catch (assert ((f True)  == 1) return ()) handler >>
    putStrLn "Done."
