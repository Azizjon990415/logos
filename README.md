# logos #Springboot #JWT #Mongo #SpringSecurity #Rest
logos of Uzbekistan
this application crated with rest thats why there is no interface for test application i advise to use postman
at first you must crate db Mongo;
than authentificate :
send json to http://localhost/api/auth/signup
ex:
{
	"password":"123456",
	"username":"superAdmin12",
	"name":"userfullname",
	"email":"example@example.com"
	
}
than you must take token :
send json to http://localhost/api/auth/signin
ex:
{
	"password":"123456",
	"username":"superAdmin12"	
}
than take a token and set barer token on response header:
ex token:"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdXBlckFkbWluMTIiLCJpYXQiOjE1NTkxNTMzMzgsImV4cCI6MTU1OTc1ODEzOH0.JolrQzwvXLz_wgIUhUUrx4p-UUQQrL2U79tBRn4k2i_WJIU81I4uBugzJ-cr_xZQCYxJ6Nlfd7J7bPCLz3CVMw"
this token don't work
than you can take icons byFormat,ByCompanyService and both
