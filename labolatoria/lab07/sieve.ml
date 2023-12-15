let sievie n = 
  let start = Array.make (n - 1) 0 in 
  for i = 2 to (n - 2) do start.(i) <- i
  done;

  for i = 2 to (n-2) do 
    if(start.(i) != 0) then
      for j = i * i to (n-2) do
        if(start.(j) mod i = 0) then start.(j) <- 0
      done;
  done;
  
  let result_size = ref 0 in
  for i = 2  to (n - 2) do 
    if(start.(i) != 0) then result_size := !result_size + 1; 
  done;
  
  let counter = ref 0 in
  let result = Array.make !result_size 0 in 
  for i = 2 to (n - 2) do
    if(start.(i) != 0) then 
      result.(!counter) <- start.(i); counter := !counter + 1
  done;
  result;;

sievie 40;;




