import * as Yup from "yup";
import { Formik, Form, Field, ErrorMessage } from "formik";
import Button from "../Button";
import PropTypes from "prop-types";

const AuthForm = ({ title, onSubmit }) => {

    const validationSchema = Yup.object({
          email: Yup.string()
            .email("Email invalide")
            .required("L'email est requis"),
          password: Yup.string()
            .min(8, "Le mot de passe doit contenir au moins 8 caractères")
            .required("Le mot de passe est requis"),
        });

    return (

        <div className="max-w-md mt-10 mx-auto bg-white p-6 rounded-lg shadow-md">
                <h2 className="text-2xl font-bold text-center text-gray-800 mb-4">{title}</h2>
                <Formik
                  initialValues={{ email: '', password: '' }}
                  validationSchema={validationSchema}
                  onSubmit={(values, { setSubmitting }) => {
                    onSubmit(values);
                    console.log("Formulaire soumis avec :", values);
                    setSubmitting(false);
                  }}
                >
                  {({ isSubmitting }) => (
                    <Form className="space-y-4">
                      <div>
                        <label htmlFor="email" className="block text-gray-700">Email :</label>
                        <Field 
                          id = "email"
                          type="email" 
                          name="email" 
                          className="w-full p-2 border border-gray-300 rounded-md focus:ring focus:ring-purple-200"
                        />
                        <ErrorMessage name="email" component="div" className="text-red-500 text-sm mt-1" />
                      </div>
          
                      <div>
                        <label htmlFor="password" className="block text-gray-700">Mot de passe :</label>
                        <Field 
                          id = "password"
                          type="password" 
                          name="password" 
                          className="w-full p-2 border border-gray-300 rounded-md focus:ring focus:ring-purple-200"
                        />
                        <ErrorMessage name="password" component="div" className="text-red-500 text-sm mt-1"/>
                      </div>
          
                      <Button 
                      disabled={isSubmitting} 
                      className="w-full bg-purple-500 text-white p-3 rounded-md hover:bg-purple-600">
                        {title}
                      </Button>
                    </Form>
                  )}
                </Formik>
              </div>

    )
};

  AuthForm.propTypes = {
    title: PropTypes.string.isRequired,  
    onSubmit: PropTypes.func,  
  };

export default AuthForm;