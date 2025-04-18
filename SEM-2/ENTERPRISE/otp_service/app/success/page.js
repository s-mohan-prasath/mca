import Link from 'next/link'
import React from 'react'

const page = () => {
    return (
        <div className='w-full min-h-screen flex items-center justify-center'>
            <div className='flex flex-col justify-center'>
                <p className='font-bold text-4xl text-green-400'>OTP Verified Successfully</p>
                <Link href={"/"} className='text-2xl underline text-center'>go back</Link>
            </div>
        </div>
    )
}

export default page