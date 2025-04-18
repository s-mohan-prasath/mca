"use client"
import { useRouter } from 'next/navigation'
import React, { useState } from 'react'
import Loading from './Loading'

const OTP = () => {
    const [isOTPSent, setIsOTPSent] = useState(false)
    const [otp, setOtp] = useState("")
    const [email, setEmail] = useState("")
    const [submitting, setSubmitting] = useState(false)

    let router = useRouter()
    const handleGetOTP = async (e) => {
        e.preventDefault()
        setSubmitting(true)
        let res = await fetch('/api/otp/generate', {
            method: "POST",
            cache: "no-cache",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                email
            }),
        })
        let body = await res.json()
        if (res.ok) {
            setIsOTPSent(true)
            alert(body.message)
        } else {
            alert(body.error)
        }
        setSubmitting(false)
    }
    const handleVerifyOTP = async (e) => {
        e.preventDefault()
        setSubmitting(true)
        let res = await fetch('/api/otp/verify', {
            method: "POST",
            cache: "no-cache",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                email, otp
            }),
        })
        let body = await res.json()
        if (res.ok) {
            alert(body.message)
            router.push("/success")
        } else {
            alert(body.error)
        }
        setSubmitting(false)
    }

    return (
        <>
            <Loading isLoading={submitting} />
            {!isOTPSent && <form className="w-3/4 md:2/3 flex flex-col" onSubmit={handleGetOTP}>
                <h1 className="my-3 text-3xl">OTP Service</h1>
                <input type="email" placeholder="Enter Your Email Address" value={email} onChange={e => setEmail(e.target.value)} name="email" className="p-2 border-2 border-gray-600 outline-2 focus:outline-amber-500" required />
                <input type="submit" className="mt-3 bg-amber-500 text-black p-2 rounded-2xl" />
            </form>}
            {isOTPSent && <form className="w-3/4 md:2/3 flex flex-col" onSubmit={handleVerifyOTP}>
                <h1 className="my-3 text-3xl">OTP Service</h1>
                <input type="text" placeholder="Enter OTP" name="otp" value={otp} onChange={e => setOtp(e.target.value)} className="p-2 border-2 border-gray-600 outline-2 focus:outline-amber-500" required />
                <input type="submit" className="mt-3 bg-amber-500 text-black p-2 rounded-2xl" />
            </form>}

        </>
    )
}

export default OTP