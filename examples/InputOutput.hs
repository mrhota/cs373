-- --------------
-- InputOutput.hs
-- --------------

{-
(>>)     :: IO a   -> IO b        -> IO b      -- 'then' operator
(>>=)    :: IO a   -> (a -> IO b) -> IO b      -- 'bind' operator
getLine  ::                          IO String
putStrLn :: String                -> IO ()
-}

main :: IO ()
main =
    putStrLn "Enter: " >>
    getLine            >>=
    putStrLn

{-
Enter:
abc
abc
-}
