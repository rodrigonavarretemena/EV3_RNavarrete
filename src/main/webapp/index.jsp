<%-- 
    Document   : index
    Created on : 17-10-2022, 19:33:19
    Author     : rodri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Concecionaria</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    
    </head>

    
    <body> 
        <br><br><br><br>
        <main class="container">
            <h1>Registro Consecionaria Automoviles</h1>
            <form nombre="frmFormulario1" class="row" method="get" action="Servlet_control">
                                          
              
                <div class="col-7">
                    <label for="inputMarca1" class="form-label">Marca</label>
                    <input type="text" class="form-control" name="inputMarca" placeholder="Mazda" required>
                </div>
              
                
                <div class="col-7">
                    <label for="inputModelo1" class="form-label"> Modelo</label>
                    <input type="text" class="form-control" name="inputModelo" placeholder="RX7" required>
                </div>
                
                
                <div class="col-7">
                    <label for="inputAno1" class="form-label">Ano</label>
                    <input type="text" class="form-control" name="inputAno" placeholder="1995" required>
                </div>
                
                <div class="col-7">
                    <label for="inputColor1" class="form-label">Color</label>
                    <input type="text" class="form-control" name="inputColor" placeholder="Amarillo" required>
                </div>
                
                <div class="col-7">
                    <label for="inputKilo1" class="form-label">Kilometraje</label>
                    <input type="text" class="form-control" name="inputKilo" placeholder="0" required>
                </div>
                
                <div>
                <br>
                <button type="submit" class="btn btn-primary">Enviar</button>
                </div>
            </form>
        </main>
        
        
    </body>
    
    
    
    
</html>
