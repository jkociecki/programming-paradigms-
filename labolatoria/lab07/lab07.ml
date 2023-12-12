let modifiedPascalI index = 
  let my_array = Array.make (index + 1) 0 in
  my_array.(0) <- 1; 
  for i = 1 to index do
    let previous = ref my_array.(0) in 
    for j = 1 to i do 
      let current = my_array.(j) in
      if i mod 2 = 0 then my_array.(j) <- !previous + my_array.(j)
      else my_array.(j) <- !previous - my_array.(j);
      previous := current;
    done;
  done; 
  my_array;;
let result = modifiedPascalI 7;;
