References
----------

#. Spring Boot
#. TLS Client Authentication
#. nodejs

Step 1 - Generate certifcate autority using openssl
---------------------------------------------------

Generate CA certificate
~~~~~~~~~~~~~~~~~~~~~~~

Here, Common name is BCC

.. code:: language-bash

   openssl req \
     -new \
     -x509 \
     -nodes \
     -newkey rsa:2048\
     -days 365 \
     -subj '/CN=bcc' \
     -keyout ca.key \
     -out ca.crt
   Copy

Generate Server Certificate
~~~~~~~~~~~~~~~~~~~~~~~~~~~

Generate Server Key
^^^^^^^^^^^^^^^^^^^

.. code:: language-bash

   openssl genrsa \
     -out server.key 2048
   Copy

Generate CSR
~~~~~~~~~~~~

Here common name is localhost

.. code:: language-bash

   openssl req \
     -new \
     -key server.key \
     -subj '/CN=localhost' \
     -out server.csr
   Copy

Generate Signed Certificate
~~~~~~~~~~~~~~~~~~~~~~~~~~~

.. code:: language-bash

   openssl x509 \
     -req \
     -in server.csr \
     -CA ca.crt \
     -CAkey ca.key \
     -CAcreateserial \
     -days 365 \
     -out server.crt
   Copy

Generate Client Certificate
~~~~~~~~~~~~~~~~~~~~~~~~~~~

Generate Client Key
^^^^^^^^^^^^^^^^^^^

.. code:: language-bash

   openssl genrsa \
     -out client.key 2048
   Copy

.. _generate-csr-1:

Generate CSR
~~~~~~~~~~~~

Here common name is client's name

.. code:: language-bash

   openssl req \
     -new \
     -key client.key \
     -subj '/CN=torsho' \
     -out client.csr
   Copy

.. _generate-signed-certificate-1:

Generate Signed Certificate
~~~~~~~~~~~~~~~~~~~~~~~~~~~

.. code:: language-bash

   openssl x509 \
     -req \
     -in client.csr \
     -CA ca.crt \
     -CAkey ca.key \
     -CAcreateserial \
     -days 365 \
     -out client.crt
   Copy

Testing the server
------------------

.. code:: language-bash

   curl \
     --cacert ca.crt \
     --key client.key \
     --cert client.crt \
     https://localhost:3000
   Copy

