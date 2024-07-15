import { Button, TextField, Typography } from "@mui/material";
import { postSweetOrderAPICall } from "../Services/SweetMartService";
import { getToken } from "../Services/AuthServices";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

const Checkout = ({ user }) => {

    // Initialize state variables
    const navigate = useNavigate();
    const [cart, setCart] = useState(null);
    const [deliveryDetails, setDeliveryDetails] = useState({
        address: '',
        city: '',
        state: '',
        zip: '',
        phone: ''
    });
    const [errors, setErrors] = useState({
        address: false,
        city: false,
        state: false,
        zip: false,
        phone: false
    });

    // Load user cart on component mount
    useEffect(() => {
        if (user) {
            setCart(user.cart)
        }
    }, [user]);

    // Handle input change in form fields
    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setDeliveryDetails({ ...deliveryDetails, [name]: value });
        // Reset error state when user starts typing
        setErrors({ ...errors, [name]: false });
    };

    // Validate form fields
    const validateForm = () => {
        let isValid = true;
        const newErrors = { ...errors };

        // Check for empty fields
        Object.keys(deliveryDetails).forEach(field => {
            if (!deliveryDetails[field]) {
                newErrors[field] = true;
                isValid = false;
            }
        });

        setErrors(newErrors);
        return isValid;
    };

    // Navigate to payment page if form is valid
    const navigateToPayment = () => {
        if (validateForm()) {
            navigate('/payment');
        }
    };

    // Render loading state if user or cart is not loaded yet
    if (!user || !cart) {
        return <Typography>Loading...</Typography>;
    }

    // Render message if cart is empty
    if (!cart.listProduct || cart.listProduct.length === 0) {
        return <Typography>No items in the cart.</Typography>;
    } else {
        // Render checkout form and cart details
        return (
            <>
                <div style={{ display: "flex" }}>
                    <div style={{
                        width: "60%",
                        borderRight: '0.5px solid grey',
                        padding: '20px'
                    }}>
                        {/* Delivery Details Form */}
                        <Typography variant="h6" gutterBottom>Delivery Details</Typography>
                        <form>
                            <TextField
                                label="Address"
                                name="address"
                                value={deliveryDetails.address}
                                onChange={handleInputChange}
                                fullWidth
                                margin="normal"
                                required
                                error={errors.address} // Display error state if address is empty
                            />
                            <TextField
                                label="City"
                                name="city"
                                value={deliveryDetails.city}
                                onChange={handleInputChange}
                                fullWidth
                                margin="normal"
                                required
                                error={errors.city} // Display error state if city is empty
                            />
                            <TextField
                                label="State"
                                name="state"
                                value={deliveryDetails.state}
                                onChange={handleInputChange}
                                fullWidth
                                margin="normal"
                                required
                                error={errors.state} // Display error state if state is empty
                            />
                            <TextField
                                label="Zip Code"
                                name="zip"
                                value={deliveryDetails.zip}
                                onChange={handleInputChange}
                                fullWidth
                                margin="normal"
                                required
                                error={errors.zip} // Display error state if zip code is empty
                            />
                            <TextField
                                label="Phone"
                                name="phone"
                                value={deliveryDetails.phone}
                                onChange={handleInputChange}
                                fullWidth
                                margin="normal"
                                required
                                error={errors.phone} // Display error state if phone is empty
                            />
                        </form>
                    </div>
                    <div style={{
                        width: "40%",
                        display: "flex",
                        flexDirection: "column",
                        padding: "40px"
                    }}>
                        {/* Cart Details */}
                        <div>
                            {cart.listProduct.map(product => {
                                return (
                                    <div style={{
                                        display: "flex",
                                        justifyContent: "space-between",
                                        alignItems: "center",
                                        marginBottom: '10px'
                                    }} key={product.id}>
                                        <div style={{
                                            display: "flex"
                                        }}>
                                            <img style={{
                                                width: "50px",
                                                height: "50px",
                                                borderRadius: "5px",
                                                objectFit: "cover",
                                                marginRight: "10px"
                                            }} src={product.photoPath} alt="" />
                                            <Typography>{product.name}</Typography>
                                        </div>
                                        <div>
                                            <Typography style={{textAlign : "right"}}>{product.price}</Typography>
                                        </div>
                                    </div>
                                );
                            })}
                        </div>
                        <br />
                        <br />
                        {/* Total Summary */}
                        <div style={{
                            display: "flex",
                            justifyContent: "space-between"
                        }}>
                            <div>
                                <Typography>Sub total</Typography>
                                <Typography>Shipping</Typography>
                                <Typography variant="h5">Total</Typography>
                                <Typography>Including 5% of GST</Typography>
                            </div>
                            <div>
                                <Typography>₹{cart.grandTotal}</Typography>
                                <Typography>₹100</Typography>
                                <Typography variant="h5">₹{cart.grandTotal + 100}</Typography>
                            </div>
                        </div>
                        <br />
                        {/* Proceed to Payment Button */}
                        <Button
                            className="button"
                            onClick={navigateToPayment}
                        >
                            Proceed to Payment
                        </Button>  
                    </div>
                </div>
            </>
        );
    }
}

export default Checkout;
