  	  </main>
     
     <div class="bg-dark">
        <footer class="container p-2">
            <p>&copy; Company 2017-2020</p>
        </footer>
     </div>

   
    <!-- Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    
    <!-- datatables -->
    <script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>

	<!-- cifrado en MD5 -->
 	<script src="js/md5.min.js"></script>

    <!-- custom js -->
    <script>
        // ejecuta la funcion cuando todo el documento de html DOM este listo y cargado
        $(document).ready(function() {
            // seleccion por id => #example y ejecuta el plugin .DataTable();
            $('.tabla').DataTable();
        });
        
        function init() {
        	console.log('Documento cargado y listo');
        	
        	var pass = '123456';
        	var hax = md5( pass );
        	console.debug("pass: " + pass);
        	console.debug("hax: " + hax);
        }
        
        
    </script>    
    
  </body>
</html>