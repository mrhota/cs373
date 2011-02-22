-- --------------
-- CommandLine.hs
-- --------------

{-
% CommandLine.hs.app Nothing to be done.
-}

{-
(>>)     :: IO a   -> IO b        -> IO b          -- 'then' operator
(>>=)    :: IO a   -> (a -> IO b) -> IO b          -- 'bind' operator
assert   :: Bool   -> a           -> a
flip     :: (a -> b -> c)         -> (b -> a -> c)
getArgs  ::                          IO [String]
putStrLn :: String                -> IO ()
return   :: a                     -> IO a
-}

import Control.Exception  (assert)
import System.Environment (getArgs)

main :: IO ()
main =
    putStrLn "CommandLine.hs"                                                     >>
    getArgs                                                                       >>=
--  (\x -> assert (x == ["Nothing", "to", "be", "done."]) return ())              >>
--  (\x -> (flip assert) (return ()) (x == ["Nothing", "to", "be", "done."]))     >>
--  (\x -> (flip assert) (return ()) ((== ["Nothing", "to", "be", "done."]) x))   >>
--  (\x -> ((flip assert) (return ())) ((== ["Nothing", "to", "be", "done."]) x)) >>
    ((flip assert) (return ())) . (== ["Nothing", "to", "be", "done."])           >>
    putStrLn "Done."
