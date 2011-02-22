-- ------------------
-- FileInputOutput.hs
-- ------------------

{-
% FileInputOutput.hs.app FileInputOutput.hs
-}

{-
(>>=)    :: IO a     -> (a -> IO b) -> IO b        -- 'bind' operator
getArgs  ::                            IO [String]
head     :: [a]                     -> a
putStrLn :: String                  -> IO ()
readFile :: FilePath                -> IO String
-}

import System.Environment (getArgs)

main :: IO ()
main =
    getArgs                   >>=
--  (\x -> readFile (head x)) >>=
    (readFile . head)         >>=
    putStrLn
