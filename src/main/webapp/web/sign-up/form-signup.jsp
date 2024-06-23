

<!-- Section: Design Block -->
<section class="background-radial-gradient overflow-hidden">
  <style>
    .background-radial-gradient {
      background-color: hsl(218, 41%, 15%);
      background-image: radial-gradient(650px circle at 0% 0%,
          hsl(218, 41%, 35%) 15%,
          hsl(218, 41%, 30%) 35%,
          hsl(218, 41%, 20%) 75%,
          hsl(218, 41%, 19%) 80%,
          transparent 100%),
        radial-gradient(1250px circle at 100% 100%,
          hsl(218, 41%, 45%) 15%,
          hsl(218, 41%, 30%) 35%,
          hsl(218, 41%, 20%) 75%,
          hsl(218, 41%, 19%) 80%,
          transparent 100%);
    }

    #radius-shape-1 {
      height: 220px;
      width: 220px;
      top: -60px;
      left: -130px;
      background: radial-gradient(#44006b, #ad1fff);
      overflow: hidden;
    }

    #radius-shape-2 {
      border-radius: 38% 62% 63% 37% / 70% 33% 67% 30%;
      bottom: -60px;
      right: -110px;
      width: 300px;
      height: 300px;
      background: radial-gradient(#44006b, #ad1fff);
      overflow: hidden;
    }

    .bg-glass {
      background-color: hsla(0, 0%, 140%, 0.6) !important;
      backdrop-filter: saturate(500%) blur(55px);
    }
    .title-register { 
	    color: blue; 
	    font-family: 'Raleway',sans-serif; 
	    font-size: 50px; 
	    font-weight: 800; 
	    margin: 0 0 24px; 
	    text-align: center; 
	    text-transform: uppercase; 
    }
  </style>

  <div class="container px-4 py-5 px-md-5 text-center text-lg-start my-5">
    <div class="row gx-lg-5 align-items-center mb-5">
      <div class="col-lg-6 mb-5 mb-lg-0" style="z-index: 10">
        <h1 class="my-5 display-5 fw-bold ls-tight" style="color: hsl(218, 81%, 95%)">
          The best offer <br />
          <span style="color: hsl(218, 81%, 75%)">for your business</span>
        </h1>
        <p class="mb-4 opacity-70" style="color: hsl(218, 81%, 85%)">
          Lorem ipsum dolor, sit amet consectetur adipisicing elit.
          Temporibus, expedita iusto veniam atque, magni tempora mollitia
          dolorum consequatur nulla, neque debitis eos reprehenderit quasi
          ab ipsum nisi dolorem modi. Quos?
        </p>
      </div>

      <div class="col-lg-6 mb-5 mb-lg-0 position-relative">
        <div id="radius-shape-1" class="position-absolute rounded-circle shadow-5-strong"></div>
        <div id="radius-shape-2" class="position-absolute shadow-5-strong"></div>

        <div class="card bg-glass">
          <div class="card-body px-4 py-5 px-md-5">
            <form method="POST">
            	<h3 class="title-register">REGISTER</h3>
              <!-- 2 column grid layout with text inputs for the first and last names -->
              <div class="row">
                <div class="col-md-12 mb-2">
                  <div data-mdb-input-init class="form-outline">
                    <input type="text" id="form3Example1" class="form-control" name="username" required value="${us.username }"/>
                    <label class="form-label " for="form3Example1">Username</label>
                  </div>
                </div>
                <div class="col-md-12 mb-2">
                  <div data-mdb-input-init class="form-outline">
                    <input type="email" id="form3Example2" class="form-control" name="email" required/>
                    <label class="form-label" for="form3Example2">Email</label>
                  </div>
                </div>
              </div>

              <!-- Email input -->
              <div data-mdb-input-init class="form-outline mb-2">
                <input type="password" id="form3Example3" class="form-control" name="password" required/>
                <label class="form-label" for="form3Example3">Password</label>
              </div>

              <!-- Password input -->
              <div data-mdb-input-init class="form-outline mb-2">
                <input type="password" id="form3Example4" class="form-control" name="repassword" required/>
                <label class="form-label" for="form3Example4">Repassword</label>
              </div>

              <!-- Checkbox -->
              <div class="form-check mb-2">
                <div class="form-check">
					<input class="form-check-input" type="checkbox" id="invalidCheck2"
						required> <label class="form-check-label"
						for="invalidCheck2"> Agree to terms and conditions </label>
				</div>
              </div>

              <!-- Submit button Sign up -->
              <button type="submit" data-mdb-button-init data-mdb-ripple-init class="btn btn-primary btn-block mb-2 form-control" formaction="/WebASMServlet/register">
                Sign up
              </button>
              
              <!-- Submit button Sign in-->
              <a type="button" data-mdb-button-init data-mdb-ripple-init class="btn btn-success btn-block mb-4 form-control" href="/WebASMServlet/login">
                Sign in
              </a>

              <!-- Register buttons -->
              <div class="text-center">
                <p>or sign up with:</p>
                <button type="button" data-mdb-button-init data-mdb-ripple-init class="btn btn-link btn-floating mx-1">
                  <i class="fab fa-facebook-f"></i>
                </button>

                <button type="button" data-mdb-button-init data-mdb-ripple-init class="btn btn-link btn-floating mx-1">
                  <i class="fab fa-google"></i>
                </button>

                <button type="button" data-mdb-button-init data-mdb-ripple-init class="btn btn-link btn-floating mx-1">
                  <i class="fab fa-twitter"></i>
                </button>

                <button type="button" data-mdb-button-init data-mdb-ripple-init class="btn btn-link btn-floating mx-1">
                  <i class="fab fa-github"></i>
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<!-- Section: Design Block -->